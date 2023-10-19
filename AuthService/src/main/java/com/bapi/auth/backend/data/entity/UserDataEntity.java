package com.bapi.auth.backend.data.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "userDetails")
public class UserDataEntity {
    @Id
    private String id;
    @Version
    private int version;
    private Long userId;
    private String fullName;
    private String phoneNo;
    private String picture;
    private String firstName;
    private String lastName;
}
