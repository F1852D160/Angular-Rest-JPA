package cl.clarochile.intranet.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.hibernate.validator.constraints.NotEmpty;

import cl.clarochile.intranet.util.JsonDateDeserializer;
import cl.clarochile.intranet.util.JsonDateSerializer;

@Entity
@Table(name="usuario")
@Access(AccessType.PROPERTY)
public class User implements Serializable {
    
	private static final long serialVersionUID = 3826118552917265621L;
	private Long id;
    private String name;
    private String lastname;
    private String motherLastname;
    private Date birthDate;
    private String email;
    private String phone;
    
    public User() {
    
    }
    
    public User(Long id, String name, String lastname,
                    String motherLastname, Date birthDate,
                    String email, String phone) {
                    
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.motherLastname = motherLastname;
        this.birthDate = birthDate;
        this.email = email;
        this.phone = phone;
    }
    
    @Id @GeneratedValue
    @Column(name="usuario_id")
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="nombre", length=50, nullable=false)
    @NotEmpty
    @Size(min=2)
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    @Column(name="ap_paterno", length=100, nullable=false)
    @NotEmpty
    @Size(min=2)
    public String getLastname() {
    	return lastname;
    }
    
    public void setLastname(String lastname) {
    	this.lastname = lastname;
    }
    
    @Column(name="ap_materno", length=100)
    @NotEmpty
    @Size(min=2)
    public String getMotherLastname() {
    	return motherLastname;
    }
    
    public void setMotherLastname(String motherLastname) {
    	this.motherLastname = motherLastname;
    }
    
    @Column(name="fecha_nac", nullable=false)
    @NotEmpty
    @Temporal(TemporalType.DATE)
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    public Date getBirthDate() {
    	return birthDate;
    }
    
    public void setBirthDate(Date birthDate) {
    	this.birthDate = birthDate;
    }

    @Column(length=100, nullable=false)
    @NotEmpty
    @Size(min=8)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="telefono", length=20, nullable=false)
	@NotEmpty
	@Size(min=6)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
    @Override
    public String toString() {
    	return String.format("{Nombre: %s, Ap. Paterno: %s, Ap. Materno: %s,"+
    			"Fecha de nacimiento: %s, Email: %s, Teléfono: %s}",
    			name, lastname, motherLastname, birthDate, email, phone);
    }
    
}
    
    
