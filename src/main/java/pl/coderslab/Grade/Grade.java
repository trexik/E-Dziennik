package pl.coderslab.Grade;

import pl.coderslab.Subject.Subject;
import pl.coderslab.User.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private int grade;
    @NotNull
    private double points;
    private double maxpoints;

    @ManyToOne (cascade = CascadeType.REMOVE)
    private Subject subject;

    @ManyToOne (cascade = CascadeType.REMOVE)
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Grade() {
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public double getMaxpoints() {
        return maxpoints;
    }

    public void setMaxpoints(double maxpoints) {
        this.maxpoints = maxpoints;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", grade=" + grade +
                ", points=" + points +
                ", maxpoints=" + maxpoints +
                ", subject=" + subject +
                ", user=" + user +
                '}';
    }
}
