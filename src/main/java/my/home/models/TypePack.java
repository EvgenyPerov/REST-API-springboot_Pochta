package my.home.models;

import lombok.Getter;

@Getter
public enum TypePack {
    PARCEL("Посылка"),
    LETTER("Письмо"),
    WRAPPER("Бандероль"),
    POSTCARD("Открытка");

    private final String typeDescription;

    TypePack(String typeDescription) {
        this.typeDescription = typeDescription;
    }

}
