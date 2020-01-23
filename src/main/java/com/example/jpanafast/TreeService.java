package com.example.jpanafast;

import java.util.List;

public interface TreeService {

    List<Tree> findAllTrees();

    Tree saveTree(String name, String color);

    List<Tree> deleteTree (long id);

    List<Tree> updateTree(long id, String name, String color);
}
