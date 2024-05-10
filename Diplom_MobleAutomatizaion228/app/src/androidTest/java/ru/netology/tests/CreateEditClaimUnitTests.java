package ru.netology.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeDown;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static ru.netology.data.DataHelper.nestedScrollTo;


import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.junit4.DisplayName;

import ru.iteco.fmhandroid.ui.AppActivity;
import ru.netology.data.ReadyScreen;
import ru.netology.data.Resources;
import ru.netology.pages.ClaimPage;
import ru.netology.pages.ClaimsPage;
import ru.netology.pages.CreateClaimPage;

@LargeTest
@RunWith(AndroidJUnit4.class)

public class CreateEditClaimUnitTests {
    ClaimsPage claimsPage = new ClaimsPage();
    ClaimPage claimPage = new ClaimPage();
    CreateClaimPage createClaimPage = new CreateClaimPage();
    ClaimsPage.FilterClaimsWindow filterClaimsWindow = new ClaimsPage.FilterClaimsWindow();
    Resources resources = new Resources();
    ReadyScreen readyScreen = new ReadyScreen();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void readyScreen() {
        readyScreen.readyClaimsScreen();
    }

    String title = resources.title;
    String description = resources.description;
    String date = resources.date;
    String date2 = resources.date2;
    String time = resources.time;
    String comment = resources.comment;
    String comment2 = resources.comment2;

    @Test
    @DisplayName("29.Создание новой заявки")
    @Description("Может падать, если в списке есть новость с ранней датой" +
            "искать с прокруткой не получается")
    public void testCreateClaim() {
        claimsPage.createClaimButton.perform(click());
        createClaimPage.checkCreateClaimScreenLoaded();
        createClaimPage.fillInTitle(title);
        createClaimPage.fillInDate(date2);
        createClaimPage.fillInTime(time);
        createClaimPage.fillItDescription(description);
        createClaimPage.saveClaim();
        claimsPage.checkClaimsScreenLoaded();
        //проверяем
        claimsPage.openClaim(0);
        claimPage.checkCreatedClaimElement(title,  date2, time, description);
        // отменяем заявку
        claimPage.statusChangeButton.perform(click());
        claimPage.cancelClaim.perform(click());
    }

    @Test
    @DisplayName("30.Редактирование заявки(title, date, time, description) в статусе open")
    public void testEditClaim() {
        claimsPage.claimsFilterButton.check(matches(isDisplayed()));
        claimsPage.claimsFilterButton.perform(click());
        filterClaimsWindow.checkFilterScreenLoaded();
        filterClaimsWindow.checkOpen();
        filterClaimsWindow.uncheckInProgress();
        filterClaimsWindow.uncheckExecuted();
        filterClaimsWindow.uncheckCanceled();
        filterClaimsWindow.cLickOk();
        claimsPage.openClaim(0);
        claimPage.editClaimButton.perform(nestedScrollTo());
        claimPage.editClaimButton.perform(click());
        createClaimPage.checkEditClaimScreenLoaded();
        createClaimPage.fillInTitle(title);
        createClaimPage.fillInDate(date);
        createClaimPage.fillInTime(time);
        createClaimPage.fillItDescription(description);
        createClaimPage.saveClaim();
        claimPage.checkClaimScreenLoaded();
        claimPage.title.perform(swipeDown());
        claimPage.checkCreatedClaimElement(title, date, time, description);
    }

    @Test
    @DisplayName("31. Добавление нового комментария к заявке в статусе open")
    public void testAddNewComment() {
        claimsPage.claimsFilterButton.check(matches(isDisplayed()));
        claimsPage.claimsFilterButton.perform(click());
        filterClaimsWindow.checkFilterScreenLoaded();
        filterClaimsWindow.checkOpen();
        filterClaimsWindow.uncheckInProgress();
        filterClaimsWindow.uncheckExecuted();
        filterClaimsWindow.uncheckCanceled();
        filterClaimsWindow.cLickOk();
        claimsPage.openClaim(0);
        claimPage.addCommentButton.perform(nestedScrollTo());
        claimPage.addCommentButton.perform(click());
        claimPage.checkCommentLoaded();
        claimPage.addComment(comment);
        claimPage.checkClaimScreenLoaded();
        claimPage.addCommentButton.perform(nestedScrollTo());
        claimPage.checkComment(comment);
    }

    @Test
    @DisplayName("32. Редактирование комментария в заявке в статусе open")
    public void testEditComment() {
        claimsPage.claimsFilterButton.check(matches(isDisplayed()));
        claimsPage.claimsFilterButton.perform(click());
        filterClaimsWindow.checkFilterScreenLoaded();
        filterClaimsWindow.checkOpen();
        filterClaimsWindow.uncheckInProgress();
        filterClaimsWindow.uncheckExecuted();
        filterClaimsWindow.uncheckCanceled();
        filterClaimsWindow.cLickOk();
        claimsPage.openClaim(0);
        // add comment
        claimPage.addCommentButton.perform(nestedScrollTo());
        claimPage.addCommentButton.perform(click());
        claimPage.checkCommentLoaded();
        claimPage.addComment(comment);
        claimPage.checkClaimScreenLoaded();
        // open first comment
        claimPage.openComment(0);
        claimPage.checkCommentLoaded();
        claimPage.addComment(comment2);
        claimPage.checkClaimScreenLoaded();
        claimPage.checkComment(comment2);
    }
}
