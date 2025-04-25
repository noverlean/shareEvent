package hako.shareEvent.entities;

import java.time.LocalDateTime;

import hako.shareEvent.telegram.ChatContext;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Entity
@ToString
@Table(name = "users")
@Accessors(chain = true)
public class User {
    @Id
    @Column(name = "id")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @Column(name = "chat_id")
    private Long chat_id;

    @Column(name = "name")
    private String name;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Enumerated(EnumType.STRING)
    @Column(name = "chat_context")
    private ChatContext chatContext;
}


