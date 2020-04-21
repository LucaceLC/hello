package com.springboot.hello._20200229设计模式._0421组合模式;

import com.google.common.collect.Lists;

import java.util.List;

public interface Component {
    void killVirus();
}


class TextFile implements Component{
    @Override
    public void killVirus() {
        System.out.println("文本文件，杀毒");
    }
}

class MoviesFile implements Component{
    @Override
    public void killVirus() {
        System.out.println("电影文件，杀毒");
    }
}

class ContainerFile implements Component{
    private List<Component> components = Lists.newArrayList();

    public boolean addFile(Component component){
        return components.add(component);
    }

    @Override
    public void killVirus() {
        components.forEach(Component::killVirus);
    }
}