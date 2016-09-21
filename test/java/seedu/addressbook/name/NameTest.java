package seedu.addressbook.name;

import static org.junit.Assert.*;

import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

public class NameTest {


	@Test
	public void smallLetters_returnsTrue() throws IllegalValueException {
		Name userTest = new Name("John K Smith");
		
		assertTrue(userTest.isSimilar("john k smith"));
	}
	
	@Test
	public void differentPermutations_returnsTrue() throws IllegalValueException {
		Name userTest = new Name("smith k john");
		
		assertTrue(userTest.isSimilar("john k smith"));
	}

}
