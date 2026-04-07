package models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import sudoku.model.models.SudokuField;

public class SudokuFieldPropertyChangeTest {

    @Test
    void testSetValueFiresPropertyChangeEvent() {
        SudokuField field = new SudokuField(3);
        List<PropertyChangeEvent> capturedEvents = new ArrayList<>();

        field.addPropertyChangeListener(capturedEvents::add);

        field.setValue(7);

        assertEquals(1, capturedEvents.size());

        PropertyChangeEvent event = capturedEvents.get(0);
        assertEquals("value-changed", event.getPropertyName());
        assertEquals(3, event.getOldValue());
        assertEquals(7, event.getNewValue());
    }
}