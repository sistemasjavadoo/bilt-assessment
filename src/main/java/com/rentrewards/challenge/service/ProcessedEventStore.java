package com.rentrewards.challenge.service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Tracks which webhook events have already been processed, so that the
 * RewardsEngine can ignore duplicate deliveries from the payment processor.
 */
public class ProcessedEventStore {

    private final Set<String> processedEventIds = ConcurrentHashMap.newKeySet();

    /**
     * Atomically claims an eventId for processing.
     *
     * @return true if this call claimed the eventId, false if it was already processed.
     */
    public boolean markProcessed(String eventId) {
        return processedEventIds.add(eventId);
    }
}
