package be.udemy.oneToMany;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")private String lastName;
    
    
}
