package org.example.oj.response;

import org.example.oj.entity.Tag;

import java.io.Serializable;
import java.util.List;

/**
 * 顶级Tag
 */
public class TagVO implements Serializable {

    private Integer id;

    private Tag parentTag;

    private Integer parentId;

    private String name;

    private List<Tag> tagList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public Tag getParentTag() {
        return parentTag;
    }

    public void setParentTag(Tag parentTag) {
        this.parentTag = parentTag;
    }

    @Override
    public String toString() {
        return "TagVO{" +
                "id=" + id +
                ", parentTag=" + parentTag +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", tagList=" + tagList +
                '}';
    }
}
