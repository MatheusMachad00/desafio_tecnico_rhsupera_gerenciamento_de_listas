package model.item;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import model.list.ItemList;
import model.status.itemStatus;

public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, message = "O título deve ter no mínimo 3 caracteres.")
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private itemStatus status = itemStatus.PENDENTE;

    private Boolean prioridade = false;

    @ManyToOne
    @JoinColumn(name = "itemList_id")
    private ItemList ItemList;
}
