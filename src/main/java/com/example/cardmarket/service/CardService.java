package com.example.cardmarket.service;
import com.example.cardmarket.entity.Card;
import com.example.cardmarket.repository.CardRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CardService {

    private CardRepository cardRepository;
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> findAll() {
        return (List<Card>) cardRepository.findAll();
    }

    public Card findById(int id) {
        return cardRepository.findById(id).get();
    }

    public void add(Card card) {
        cardRepository.save(card);
    }

    public void addCards(List<Card> cards) {
        cardRepository.saveAll(cards);
    }

    public void deleteCard(int id) {
        cardRepository.deleteById(id);
    }
}
