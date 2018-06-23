package com.sinosoft.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.role.Role;
/**
 * Simple class that represents any User domain entity in any application.
 *
 * <p>Because this class performs its own Realm and Permission checks, and these can happen frequently enough in a
 * production application, it is highly recommended that the internal User {@link #getRoles} collection be cached
 * in a 2nd-level cache when using JPA and/or Hibernate.  The hibernate xml configuration for this sample application
 * does in fact do this for your reference (see User.hbm.xml - the 'roles' declaration).</p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="TRTHR_USER")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
@Transactional
public class User  implements Serializable{

    private Long id;
    private String username;//用户名 16
    private String realname;//真实名20
	private String password;//
    private String passprompt;//32
    private String passanswer;//20
    private Long usersex;//
    private String identitycard;//20
    private String address;//60
    private Long postcode;//60
    private String email;
    private String fax;
    private String telephone;
    private String mobile;
    private String ipaddress;
    private String company;
    private String companyaddress;
    private String lawyername;
    private String lawyerphone;
    private String lawyermail;
    private Long companycode;
    private String companyfax;
    private String companyip;
    private String country;
    private String province;
    private String city;
    private String county;
    private String territory;
    private Long islocked;
    private String ftphomedirectory;
    private Long idletime;
    private Long uploadrate;
    private Long downloadrate;
    private Long grade;
    private Long writepermission;
    private BigDecimal ftpport;
    private String ftpurl;
    private Date registertime;
    private BigDecimal maxloginnumber;
    private BigDecimal maxloginperip;
    private Set<Role> roles = new HashSet<Role>();
    private String starttime;
    private String endtime;
    private String usertype;
    private String ip;
    private Map<Long,String> authoriy;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="USERID")
    @SearchableId
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the username associated with this user account;
     *
     * @return the username associated with this user account;
     */
    @Column(name="username",length=16,unique=true)
    @SearchableProperty
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="email",length=24)
    @SearchableProperty
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the password for this user.
     *
     * @return this user's password
     */
    @Column(name="password",length=70)
    @SearchableProperty
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @ManyToMany(
            targetEntity=com.sinosoft.role.Role.class,
            cascade={CascadeType.ALL},
            fetch=FetchType.EAGER
        )
    @JoinTable(name="TRTHR_USER_ROLES",joinColumns={@JoinColumn(name="userid")},inverseJoinColumns={@JoinColumn(name="rolesid")})
    @Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    @Column(name="REALNAME",length=20)
    @SearchableProperty
    public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name="PASSPROMPT",length=32)
	@SearchableProperty
	public String getPassprompt() {
		return passprompt;
	}

	public void setPassprompt(String passprompt) {
		this.passprompt = passprompt;
	}

	@Column(name="PASSANSWER",length=20)
	@SearchableProperty
	public String getPassanswer() {
		return passanswer;
	}

	public void setPassanswer(String passanswer) {
		this.passanswer = passanswer;
	}

	@Column(name="USERSEX")
	@SearchableProperty
	public Long getUsersex() {
		return usersex;
	}

	public void setUsersex(Long usersex) {
		this.usersex = usersex;
	}

	@Column(name="IDENTITYCARD",length=20)
	@SearchableProperty
	public String getIdentitycard() {
		return identitycard;
	}

	public void setIdentitycard(String identitycard) {
		this.identitycard = identitycard;
	}

	@Column(name="ADDRESS",length=60)
	@SearchableProperty
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name="POSTCODE")
	@SearchableProperty
	public Long getPostcode() {
		return postcode;
	}

	public void setPostcode(Long postcode) {
		this.postcode = postcode;
	}

	@Column(name="FAX",length=16)
	@SearchableProperty
	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@Column(name="TELEPHONE",length=16)
	@SearchableProperty
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name="MOBILE",length=12)
	@SearchableProperty
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="IPADDRESS",length=60)
	@SearchableProperty
	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	@Column(name="COMPANY",length=32)
	@SearchableProperty
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name="COMPANYADDRESS",length=60)
	@SearchableProperty
	public String getCompanyaddress() {
		return companyaddress;
	}

	public void setCompanyaddress(String companyaddress) {
		this.companyaddress = companyaddress;
	}

	@Column(name="LAWYERNAME",length=10)
	@SearchableProperty
	public String getLawyername() {
		return lawyername;
	}

	public void setLawyername(String lawyername) {
		this.lawyername = lawyername;
	}

	@Column(name="LAWYERPHONE",length=16)
	@SearchableProperty
	public String getLawyerphone() {
		return lawyerphone;
	}

	public void setLawyerphone(String lawyerphone) {
		this.lawyerphone = lawyerphone;
	}

	@Column(name="LAWYERMAIL",length=60)
	@SearchableProperty
	public String getLawyermail() {
		return lawyermail;
	}

	public void setLawyermail(String lawyermail) {
		this.lawyermail = lawyermail;
	}

	@Column(name="COMPANYCODE")
	@SearchableProperty
	public Long getCompanycode() {
		return companycode;
	}

	public void setCompanycode(Long companycode) {
		this.companycode = companycode;
	}

	@Column(name="COMPANYFAX",length=16)
	@SearchableProperty
	public String getCompanyfax() {
		return companyfax;
	}

	public void setCompanyfax(String companyfax) {
		this.companyfax = companyfax;
	}

	@Column(name="COMPANYIP",length=15)
	@SearchableProperty
	public String getCompanyip() {
		return companyip;
	}

	public void setCompanyip(String companyip) {
		this.companyip = companyip;
	}

	@Column(name="COUNTRY",length=20)
	@SearchableProperty
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name="PROVINCE",length=20)
	@SearchableProperty
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	@Column(name="CITY",length=20)
	@SearchableProperty
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="COUNTY",length=20)
	@SearchableProperty
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Column(name="TERRITORY",length=20)
	@SearchableProperty
	public String getTerritory() {
		return territory;
	}

	public void setTerritory(String territory) {
		this.territory = territory;
	}

	@Column(name="ISLOCKED")
	@SearchableProperty
	public Long getIslocked() {
		return islocked;
	}

	public void setIslocked(Long islocked) {
		this.islocked = islocked;
	}

	@Column(name="FTPHOMEDIRECTORY")
	@SearchableProperty
	public String getFtphomedirectory() {
		return ftphomedirectory;
	}

	public void setFtphomedirectory(String ftphomedirectory) {
		this.ftphomedirectory = ftphomedirectory;
	}

	@Column(name="IDLETIME")
	@SearchableProperty
	public Long getIdletime() {
		return idletime;
	}

	public void setIdletime(Long idletime) {
		this.idletime = idletime;
	}

	@Column(name="UPLOADRATE")
	@SearchableProperty
	public Long getUploadrate() {
		return uploadrate;
	}

	public void setUploadrate(Long uploadrate) {
		this.uploadrate = uploadrate;
	}

	@Column(name="DOWNLOADRATE")
	@SearchableProperty
	public Long getDownloadrate() {
		return downloadrate;
	}

	public void setDownloadrate(Long downloadrate) {
		this.downloadrate = downloadrate;
	}

	@Column(name="GRADE")
	@SearchableProperty
	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	@Column(name="WRITEPERMISSION")
	@SearchableProperty
	public Long getWritepermission() {
		return writepermission;
	}

	public void setWritepermission(Long writepermission) {
		this.writepermission = writepermission;
	}

	@Column(name="FTPPORT")
	@SearchableProperty
	public BigDecimal getFtpport() {
		return ftpport;
	}

	public void setFtpport(BigDecimal ftpport) {
		this.ftpport = ftpport;
	}

	@Column(name="FTPURL")
	@SearchableProperty
	public String getFtpurl() {
		return ftpurl;
	}

	public void setFtpurl(String ftpurl) {
		this.ftpurl = ftpurl;
	}

	@Column(name="REGISTERTIME")
	@SearchableProperty
	public Date getRegistertime() {
		return registertime;
	}

	public void setRegistertime(Date registertime) {
		this.registertime = registertime;
	}

	@Column(name="MAXLOGINNUMBER")
	@SearchableProperty
	public BigDecimal getMaxloginnumber() {
		return maxloginnumber;
	}

	public void setMaxloginnumber(BigDecimal maxloginnumber) {
		this.maxloginnumber = maxloginnumber;
	}

	@Column(name="MAXLOGINPERIP")
	@SearchableProperty
	public BigDecimal getMaxloginperip() {
		return maxloginperip;
	}

	public void setMaxloginperip(BigDecimal maxloginperip) {
		this.maxloginperip = maxloginperip;
	}
	
	@Transient
	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	@Transient
	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	@Transient
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name="USERTYPE")
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	@Transient
	public Map<Long, String> getAuthoriy() {
		return authoriy;
	}

	public void setAuthoriy(Map<Long, String> authoriy) {
		this.authoriy = authoriy;
	}
	
}


