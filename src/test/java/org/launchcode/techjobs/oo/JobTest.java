package org.launchcode.techjobs.oo;


import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job(
                "Product tester",
                new Employer("ACME"),
                new Location("Desert"),
                new PositionType("Quality control"),
                new CoreCompetency("Persistence"));

        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job.getName() instanceof String);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Junior Web Dev", new Employer ("DevCorp"), new Location("Philadelphia"), new PositionType("Junior Web Dev"), new CoreCompetency("JavaScript"));

        Job job2 = new Job("Junior Web Dev", new Employer ("DevCorp"), new Location("Philadelphia"), new PositionType("Junior Web Dev"), new CoreCompetency("JavaScript"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job(
                "Software Developer",
                new Employer("LaunchCode"),
                new Location("St. Louis"),
                new PositionType("Full-Time"),
                new CoreCompetency("Java"));

        assertEquals(System.lineSeparator(), job.toString().substring(0, System.lineSeparator().length()));
        assertEquals(System.lineSeparator(),
                job.toString().substring(job.toString().length() - System.lineSeparator().length()));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job(
                "Software Developer",
                new Employer("LaunchCode"),
                new Location("St. Louis"),
                new PositionType("Full-Time"),
                new CoreCompetency("Java"));

        String newLine = System.lineSeparator();

        String expectedOutput =
                         newLine + "ID: " + job.getId() + newLine +
                        "Name: Software Developer" + newLine +
                        "Employer: LaunchCode" + newLine +
                        "Location: St. Louis" + newLine +
                        "Position Type: Full-Time" + newLine +
                        "Core Competency: Java" + newLine;

        String actualOutput = job.toString();

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job(
                "Software Developer",
                new Employer(""),
                new Location("Philadelphia"),
                new PositionType("Full-Time"),
                new CoreCompetency("JavaScript"));

        String newLine = System.lineSeparator();

        String expectedOutput =
                newLine + "ID: " + job.getId() + newLine +
                        "Name: Software Developer" + newLine +
                        "Employer: Data not available" + newLine +
                        "Location: Philadelphia" + newLine +
                        "Position Type: Full-Time" + newLine +
                        "Core Competency: JavaScript" + newLine;

        String actualOutput = job.toString();

        assertEquals(expectedOutput, actualOutput);
    }
}
