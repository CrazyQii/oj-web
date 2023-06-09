package org.example.oj.response;

/**
 * select2VO
 *
 */
public class Select2VO {

    private Integer id;

    private String text;

    private Boolean selected = false;

    private Boolean disabled = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String toString() {
        return "Select2VO{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", selected=" + selected +
                ", disabled=" + disabled +
                '}';
    }
}
