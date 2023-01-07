package org.example.ast;

import java.util.List;

public interface Node {
     Range getRange();
     List<Node> getChildren();
}
