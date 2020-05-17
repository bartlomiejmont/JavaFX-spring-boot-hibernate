package com.example.ogloszenia.model;

import com.example.ogloszenia.type.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @Column (unique = true)
    private String login;

    @NonNull
    @Column (unique = true)
    private String email;

    @NonNull
    private String password;

    @NonNull
    @Enumerated(EnumType.STRING)
    private UserType type;

    @OneToOne
    @JoinColumn(name = "adress_id")
    private Adress adress;

    @OneToMany(mappedBy = "user")
    private List<HousingAds> housingAds;

    @OneToMany(mappedBy = "user")
    private List<ItemAds> itemAds;

    @OneToMany(mappedBy = "user")
    private List<JobPosting> jobPostings;

    @OneToMany(mappedBy = "user")
    private List<RentalAds> rentalAds;

    @OneToMany(mappedBy = "user")
    private List<UserOpinion> userOpinions;

    @Override
    public java.lang.String toString() {
        return String.valueOf(id) ;
    }
}