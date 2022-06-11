package _99_extra._00_league_of_amazing_astronauts;

import _99_extra._00_league_of_amazing_astronauts.LeagueOfAmazingAstronauts;
import _99_extra._00_league_of_amazing_astronauts.models.Astronaut;
import _99_extra._00_league_of_amazing_astronauts.models.Rocketship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

/*

When writing the tests, mock both the Rocketship and Astronaut for the sake of practice.
 */
class LeagueOfAmazingAstronautsTest {

    LeagueOfAmazingAstronauts underTest = new LeagueOfAmazingAstronauts();
    @Mock
    	Rocketship rocket;
    @Mock
    	Astronaut astro;

    @BeforeEach
    void setUp() {
    	MockitoAnnotations.openMocks(this);
    	underTest  = new LeagueOfAmazingAstronauts();
    	underTest.setRocketship(rocket);
    }

    @Test
    void itShouldPrepareAstronaut() {
        //given
    	when(astro.isTrained()).thenReturn(true);
        //when
    	underTest.prepareAstronaut(astro);
        //then
    	verify(astro, times(1)).train();
    	verify(rocket,times(1)).loadOccupant(astro);
    }

    @Test
    void itShouldLaunchRocket() {
        //given
    	String destination = "Mars";
    	int milesToDestination = 68000000;
        //when
    	when(rocket.isLoaded()).thenReturn(true);
    	underTest.launchRocket(destination);
        //then
    	verify(rocket, times(1)).setDestination(destination, milesToDestination);
    	verify(rocket, times(1)).launch();
    }


    @Test
    void itShouldThrowWhenDestinationIsUnknown() {
        //given
    	String destination = "Mars";
    	when(rocket.isLoaded()).thenReturn(true);
        //when
        //then
    }

    @Test
    void itShouldThrowNotLoaded() {
        //given
    	String destination = "Venus";
    	when(rocket.isLoaded()).thenReturn(false);
        //when
        Exception e = assertThrows(Exception.class, () -> underTest.launchRocket(destination));
        assertEquals("Rocketship is not loaded", e.getMessage());
        //then

    }
}