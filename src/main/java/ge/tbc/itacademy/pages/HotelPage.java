package ge.tbc.itacademy.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HotelPage {
    public SelenideElement
            hotelTitle = $("#hp_hotel_name h2"),
            reservationButton = $("#hp_book_now_button"),
            reserveButton = $("button[id*='book_now']"),
            hotelInfo = $("div[data-component='hotel/new-rooms-table/summary/rooms']"),
            illReserveButton = $("div.hprt-reservation-cta"),
            shareButton = $("button[data-testid='property-share-button']"),
            copyLink = $("button[data-testid='property-share-item']");
}
