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
}
