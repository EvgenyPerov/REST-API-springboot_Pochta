package my.home.models;

public enum TypeStatus {
    PROCESS("В обработке"),
    SEND("Отправлено - в пути"),
    READY("Готово к выдаче"),
    COMPLETE("Получено");

    private final String nameDescription;

    TypeStatus(String nameDescription) {
        this.nameDescription = nameDescription;
    }

}
