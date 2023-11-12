package com.bharatanve.workoutappdemo.repository

import com.bharatanve.workoutappdemo.model.APIResponse
import com.bharatanve.workoutappdemo.model.Category1
import com.bharatanve.workoutappdemo.model.Data
import com.bharatanve.workoutappdemo.model.Plan1
import com.bharatanve.workoutappdemo.model.Section1
import com.bharatanve.workoutappdemo.model.Section2
import com.bharatanve.workoutappdemo.model.Section3
import com.bharatanve.workoutappdemo.model.Section4

val fakeData : APIResponse = APIResponse(
    data = Data(
        section_1 = Section1(
            "Build Bigger Biceps Unleash Your Arm Power",
            progress = "80"
        ),
        section_2 = Section2(
            accuracy = "85%",
            workout_duration = "2 hours",
            reps = 15,
            calories_burned = 850
        ),
        section_3 = Section3(
            plan_1 = Plan1(
                difficulty = "Beginner",
                plan_name = "Toned Arm"
            ),
            plan_2 = Plan1(
                difficulty = "Expert",
                plan_name = "Toned Arm"
            )
        ),
        section_4 = Section4(
            category_1 = Category1(
                category_name = "Bicep",
                no_of_exercises = "4"
            ),
            category_2 = Category1(
                category_name = "Yoga",
                no_of_exercises = "6"
            ),
        )
    )
)