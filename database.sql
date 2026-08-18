CREATE TABLE notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    subject_code VARCHAR(10) NOT NULL,
    subject_name VARCHAR(100) NOT NULL,
    title VARCHAR(150) NOT NULL,
    download_link VARCHAR(500) NOT NULL,
    upvotes INT DEFAULT 0,
    downvotes INT DEFAULT 0,
    uploaded_by VARCHAR(100) DEFAULT 'Anonymous'
);
