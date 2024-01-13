package kuzstu.com.Applications.repository;

import kuzstu.com.Applications.model.Card;

import java.util.List;

public abstract class CardRepository {

    public abstract List<Card> readAll();

    public abstract Card readCard(int id);

    public abstract void createCard(Card card);

    public abstract void updateClass(Card card, int id);
}
