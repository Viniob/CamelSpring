package com.br.camelspring;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

import static org.hamcrest.CoreMatchers.any;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.Test;

import com.br.camelspring.model.PersonModel;
import com.br.camelspring.repository.PersonRepository;
import com.br.camelspring.service.PersonService;

public class PersonServiceTest {

	@Mock
	private PersonRepository personRepositoryMock;

	@InjectMocks
	private PersonService personService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddPerson_returnsNewPerson() {
		when(personRepositoryMock.createPerson(new PersonModel(2, "created by teste", 999))).thenReturn(new PersonModel());

		PersonModel person = new PersonModel();
		assertThat(personService.createPerson(person), is(notNullValue()));
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testUpdatePerson() {
		when(personRepositoryMock.updatePerson(new PersonModel(3, "updated by test method", 333))).then(new Answer<PersonModel>() {
			@Override
			public PersonModel answer(InvocationOnMock invocation) throws Throwable {
				Object[] arguments = invocation.getArguments();

				if (arguments != null && arguments.length > 0 && arguments[0] != null) {
					PersonModel person = (PersonModel) arguments[0];
					person.setId(1);
					return person;
				}

				return null;
			}
		});
		
		PersonModel person = new PersonModel();
		assertThat(personService.createPerson(person), is(notNullValue()));
	}
	
	
	
//	@Test(expected = RuntimeException.class)
//	public void testAddCustomer_throwsException() {
//
//        when(personRepositoryMock.createPerson(new PersonModel(6, "error by method teste", 555)))
//        	.thenThrow(RuntimeException.class);
//
//       PersonModel personModel = new PersonModel(); 
//       personService.createPerson(personModel);
//    }
	
	

}
