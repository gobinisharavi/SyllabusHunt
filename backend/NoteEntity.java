package com.syllabusflow.entity;

public class NoteEntity {
    private Long id;
    private String subjectCode;
    private String subjectName;
    private String title;
    private String downloadLink;
    private int upvotes;
    private int downvotes;

    // Getters and Setters
    public Long getId() { 
      return id;
    }
    public void setId(Long id) {
      this.id = id; 
    }
    public String getSubjectCode() {
      return subjectCode; 
    }
    public void setSubjectCode(String subjectCode) {
      this.subjectCode = subjectCode;
    }
    public String getSubjectName() { 
      return subjectName;
    }
    public void setSubjectName(String subjectName) { 
      this.subjectName = subjectName;
    }
    public String getTitle() { 
      return title;
    }
    public void setTitle(String title) { 
      this.title = title;
    }
    public String getDownloadLink() { 
      return downloadLink; 
    }
    public void setDownloadLink(String downloadLink) { 
      this.downloadLink = downloadLink;
    }
    public int getUpvotes() {
      return upvotes; 
    }
    public void setUpvotes(int upvotes) { 
      this.upvotes = upvotes;
    }
    public int getDownvotes() {
      return downvotes; 
    }
    public void setDownvotes(int downvotes) { 
      this.downvotes = downvotes;
    }
}
