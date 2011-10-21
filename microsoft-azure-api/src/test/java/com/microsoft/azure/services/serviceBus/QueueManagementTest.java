package com.microsoft.azure.services.serviceBus;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.w3._2005.atom.Content;
import org.w3._2005.atom.Entry;

import com.microsoft.azure.services.serviceBus.contract.QueueDescription;
import com.microsoft.azure.services.serviceBus.contract.ServiceBusContract;


public class QueueManagementTest {
	@Test
	public void testGetQueueAcquiresDescriptionFromServer() {
		// Arrange
		ServiceBusContract contract = mock(ServiceBusContract.class);

		Entry entry = new Entry();
		when(contract.getQueue("Hello")).thenReturn(entry);

		entry.setContent(new Content());
		entry.getContent().setQueueDescription(new QueueDescription());
		entry.getContent().getQueueDescription().setMessageCount(73L);
		
		// Act
		ServiceBusClient client = new ServiceBusClient(contract);
		Queue helloQueue = client.getQueue("Hello");
		helloQueue.fetch();
		
		// Assert
		assertEquals(73, helloQueue.getMessageCount().longValue());
	}
	
	@Test
	public void queueCreateSendsCreateQueueDescriptionMessage() throws DatatypeConfigurationException {
		// Arrange
		ServiceBusContract contract = mock(ServiceBusContract.class);
		
		// Act
		ServiceBusClient client = new ServiceBusClient(contract);
		Queue helloQueue = client.getQueue("MyNewQueue");
		helloQueue.setLockDuration(DatatypeFactory.newInstance().newDuration(60 * 1000L));
		helloQueue.setMaxSizeInMegabytes(42L);
		helloQueue.save();
		
		// Assert
		ArgumentCaptor<Entry> argument = ArgumentCaptor.forClass(Entry.class);
		verify(contract).createQueue(argument.capture());
		Entry entry = argument.getValue();
		QueueDescription model = entry.getContent().getQueueDescription();
		
		assertEquals("MyNewQueue", entry.getTitle());
		assertEquals(DatatypeFactory.newInstance().newDuration(60 * 1000L), model.getLockDuration());
		assertEquals(42, model.getMaxSizeInMegabytes().longValue());
	}
}
