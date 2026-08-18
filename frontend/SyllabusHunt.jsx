import React, { useState, useEffect } from 'react';
import './SyllabusHunt.css';

const SyllabusHunt = () => {
    const [notes, setNotes] = useState([]);
    const [subjectCode, setSubjectCode] = useState("CS3401");

    useEffect(() => {
        fetchNotes();
    }, [subjectCode]);

    const fetchNotes = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/notes/subject/${subjectCode}`);
            const data = await response.json();
            setNotes(data);
        } catch (error) {
            console.error("Error fetching notes:", error);
        }
    };

    const handleUpvote = async (id) => {
        try {
            const response = await fetch(`http://localhost:8080/api/notes/${id}/upvote`, {
                method: 'POST'
            });
            if (response.ok) {
                fetchNotes(); // Automatic state update re-renders layout and priority sorting
            }
        } catch (error) {
            console.error("Error upvoting note:", error);
        }
    };

    return (
        <div className="notes-container">
            <h2>SyllabusHunt: Semester Study Resource Hub</h2>
            <div className="filter-section">
                <label>Select Subject Code: </label>
                <select value={subjectCode} onChange={(e) => setSubjectCode(e.target.value)}>
                    <option value="CS3401">CS3401 - Database Management Systems</option>
                    <option value="CS3402">CS3402 - Java Programming</option>
                </select>
            </div>

            <div className="notes-grid">
                {notes.map((note) => (
                    <div key={note.id} className="note-card">
                        <span className="subject-badge">{note.subjectCode}</span>
                        <h3>{note.title}</h3>
                        <p className="subject-name">{note.subjectName}</p>
                        
                        <div className="card-actions">
                            <a href={note.downloadLink} target="_blank" rel="noreferrer" className="btn-download">
                                Download PDF
                            </a>
                            <button className="btn-upvote" onClick={() => handleUpvote(note.id)}>
                                  Upvote ({note.upvotes})
                            </button>
                        </div>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default SyllabusHunt;
