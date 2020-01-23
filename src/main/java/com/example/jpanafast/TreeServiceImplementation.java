package com.example.jpanafast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreeServiceImplementation implements TreeService {

    private TreeRepo treeRepo;

    @Autowired
    public TreeServiceImplementation(TreeRepo treeRepo) {
        this.treeRepo = treeRepo;
    }

    @Override
    public List<Tree> findAllTrees() {
        return treeRepo.findAll();
    }

    @Override
    public Tree saveTree(String name, String color) {
        Tree tree = new Tree(name, color);
        return treeRepo.save(tree);
    }

    @Override
    public List<Tree> deleteTree(long id) {
        for (Tree tree : treeRepo.findAll()) {
            if (tree.getId() == id) {
                treeRepo.delete(tree);
            }
        }
        return treeRepo.findAll();
    }

    @Override
    public List<Tree> updateTree(long id, String name, String color) {
        for (Tree tree : treeRepo.findAll()) {
            if (tree.getId() == id) {
                tree.setName(name);
                tree.setColor(color);
                treeRepo.save(tree);
            }
        }
        return treeRepo.findAll();
    }
}
