package at.fh.swengb.javalist.model;

import java.io.Serializable;

/**
 * Created by Lukas Schneider on 23.11.2016.
 */

public class JavaMethod implements Serializable {

    private String nameMethod;
    private String description;
    private String creator;
    private String contact;

    public JavaMethod() {
    }

    public JavaMethod(String nameMethod, String description, String creator, String contact) {
        this.nameMethod = nameMethod;
        this.description = description;
        this.creator = creator;
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JavaMethod that = (JavaMethod) o;

        if (nameMethod != null ? !nameMethod.equals(that.nameMethod) : that.nameMethod != null)
            return false;
        return creator != null ? creator.equals(that.creator) : that.creator == null;

    }

    @Override
    public int hashCode() {
        int result = nameMethod != null ? nameMethod.hashCode() : 0;
        result = 31 * result + (creator != null ? creator.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(nameMethod).append(" by ")
                .append(creator)
                .append('\n')
                .append(contact).append('\n')
                .append(description);
        return sb.toString();
    }

    public String getNameMethod() {
        return nameMethod;
    }

    public void setNameMethod(String nameMethod) {
        this.nameMethod = nameMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
