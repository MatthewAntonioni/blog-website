package com.example.demo.publishing;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")

public class posts {

@Id
@Column(name = "postID")

private int postID;

@Column(name = "Title")
private String title;

@Column(name = "content")

private String content;

@Column(name = "preview")

private String preview;

@Column(name = "publish")

private boolean publish;


// add sets to title preivew and content (when) i add unit tests

public int getPostID() {
    return postID;
}

public String getTitle() {
    return title;
}

public String getContent() {
    return content;
}

public String getPreview() {
    return preview;
}

public boolean isPublish() {
    return publish;
}

public int setPostID(int postID) {
    this.postID = postID;
    return postID;

}

public String setTitle(String title) {
    this.title = title;
    return title;
}

public String setContent(String content) {
    this.content = content;
    return content;
}

public String setPreview(String preview) {
    this.preview = preview;
    return preview;
}

public boolean setPublish(boolean publish) {
    this.publish = publish;
    return publish;
}

}
