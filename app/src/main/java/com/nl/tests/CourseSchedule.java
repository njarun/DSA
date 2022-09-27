package com.nl.tests;

public class CourseSchedule {

    public static void main(String[] args) {

        int n = 3;
        int[][] prerequisites = {{2,1},{1,0}};
        System.out.println("Can finish - " + canFinishWrong(n, prerequisites));
    }

    public static boolean canFinishWrong(int numCourses, int[][] prerequisites) {

        int index = numCourses - 1;

        if(prerequisites.length == 0 || numCourses == 0) {
            return true;
        }

        if(prerequisites.length !=  numCourses - 1) {
            return false;
        }

        for (int i = 0; i < numCourses-1; i++) {

            for (int j = 0; j < numCourses-1; j++) {

                int course = prerequisites[i][j];

                if(course != index) {
                    return false;
                }

                if(j % 2 == 0)
                    index--;
            }
        }

        return true;
    }
}