package hello.hellospring.domain;


import javax.persistence.*;

@Entity
//Member는 jap가 관리하는 엔티티가 된다.
public class Member {


    @Id //pk라는 뜻
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB에다가 값을 넣지 않아도 자동으로 생성해주는 값을 - IDENTITY
    private Long id;

    //이러한 어노테이션을 가지고 DB와 매핑하는 것이다.
    @Column(name = "username")
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
