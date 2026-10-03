package io.aiops;

import java.util.*;

public final class Dag {

    private Dag() {
    }

    public static void validate(List<TaskSpec> tasks) {

        if (tasks == null || tasks.isEmpty() || tasks.size() > 100) {
            throw new IllegalArgumentException("1..100 tasks required");
        }

        Map<String, TaskSpec> nodes = new HashMap<>();

        for (var task : tasks) {

            if (nodes.put(task.id(), task) != null) {
                throw new IllegalArgumentException(
                        "Duplicate task: " + task.id()
                );
            }

            if (!Set.of(
                    "HASH",
                    "AGGREGATE",
                    "FAIL_ONCE"
            ).contains(task.kind())) {

                throw new IllegalArgumentException(
                        "Unsupported task kind"
                );
            }
        }

        Set<String> visiting = new HashSet<>();
        Set<String> done = new HashSet<>();

        for (var id : nodes.keySet()) {
            visit(id, nodes, visiting, done);
        }
    }

    private static void visit(
            String id,
            Map<String, TaskSpec> nodes,
            Set<String> visiting,
            Set<String> done
    ) {

        if (done.contains(id)) {
            return;
        }

        if (!nodes.containsKey(id)) {
            throw new IllegalArgumentException(
                    "Unknown dependency: " + id
            );
        }

        if (!visiting.add(id)) {
            throw new IllegalArgumentException(
                    "DAG contains cycle"
            );
        }

        for (var dependency : nodes.get(id).dependsOn()) {
            visit(dependency, nodes, visiting, done);
        }

        visiting.remove(id);
        done.add(id);
    }
}