Модуль controller
- пакет by.it_academy.jd2.voting.controller.http.utils
    * ServletUtils - класс, содержащий методы работы с печатью текста
- пакет by.it_academy.jd2.voting.controller.http
    * ClearServlet - сервлет, отвечающий за очищение статистики голосования
    * StatServlet - сервлет, отвечающий за полуечние статистики голосования
    * VoteServlet - сервлет, отвечающий за получение голоса и вывод накопившейся статистики голосования

Модуль dao
- пакет by.it_academy.jd2.voting.dao
    * VoteDao - класс, реализующий интерфейс IVoteDao. Отвечает за работу с данными
- пакет by.it_academy.jd2.voting.dao.api
    * IVoteDao - интерфейс, характеризующий работу с данными
- пакет by.it_academy.jd2.voting.dao.factory
    * DaoFactory - класс, выполняющий функции паттерна factory, создающий объект класса, реализующего интерфейс IVoteDao

Модуль service
- пакет by.it_academy.jd2.voting.service
    * ClearService - класс сервиса, отвечающий за очищение статистики голосования
    * StatService - класс сервиса, отвечающий за получение статистики голосования
    * VoteService - класс сервиса, отвечающий за отправку голоса
- пакет by.it_academy.jd2.voting.service.api
    * IClearService - интерфейс, описывающий сервис очищения статистики
    * IStatService - интерфейс, описывающий сервис получения статистики
    * IVoteService - интерфейс, описывающий сервис записи статистики
- пакет by.it_academy.jd2.voting.service.api.dto
    * AboutStatDto
    * AllStatDto
    * ArtistStatDto
    * GenreStatDto
    * AllStatDtoBuilder
- пакет by.it_academy.jd2.voting.service.factory
    * ServiceFactory - класс, выполняющий функции паттерна factory, создающий объекты класса, реализующего интерфейс IStatService, IVoteService, IClearService
- StatServiceTest - тестирование StatService