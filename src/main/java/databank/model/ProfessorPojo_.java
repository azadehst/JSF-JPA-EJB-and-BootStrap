package databank.model;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;


@Generated(value="Dali", date="2024-10-24T00:01:21.313-0400")
@StaticMetamodel(PhysicianPojo.class)
public class ProfessorPojo_ {
	public static volatile SingularAttribute<PhysicianPojo, Boolean> editable;
	public static volatile SingularAttribute<PhysicianPojo, Integer> id;
	public static volatile SingularAttribute<PhysicianPojo, String> lastName;
	public static volatile SingularAttribute<PhysicianPojo, String> firstName;
	public static volatile SingularAttribute<PhysicianPojo, String> email;
	public static volatile SingularAttribute<PhysicianPojo, String> phoneNumber;
	public static volatile SingularAttribute<PhysicianPojo, String> specialty;
	public static volatile SingularAttribute<PhysicianPojo, LocalDateTime> created;
	public static volatile SingularAttribute<PhysicianPojo, LocalDateTime> updated;
	public static volatile SingularAttribute<PhysicianPojo, Integer> version;
}