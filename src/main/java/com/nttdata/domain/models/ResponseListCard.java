package com.nttdata.domain.models;

import com.nttdata.infraestructure.entity.Card;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListCard {
  private String status;
  private String message;
  private List<Card> card;
}
