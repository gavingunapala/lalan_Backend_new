package com.example.Lalan.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "message_Publisher")
public class MessagePublisherEntity {
    @Id
    private String messageId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messagePbDbId;
    private String message;
}
