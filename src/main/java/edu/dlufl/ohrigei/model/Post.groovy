package edu.dlufl.ohrigei.model

class Post {
    private int id
    private String postMessage

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getPostMessage() {
        return postMessage
    }

    void setPostMessage(String postMessage) {
        this.postMessage = postMessage
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", postMessage='" + postMessage + '\'' +
                '}';
    }
}
