package jtodi.andev.a7minuteworkout

object Constants {

    fun defaultExerciseList() : ArrayList<ExerciseModel>{
        val exerciseList = ArrayList<ExerciseModel>()

        val boxing = ExerciseModel(
            1,
            "Boxing",
            R.drawable.ic_boxing,
            false,
            false
        )

        exerciseList.add(boxing)

        val squats = ExerciseModel(
            2,
            "Squat Hold",
            R.drawable.ic_squat_hold,
            false,
            false
        )

        exerciseList.add(squats)

        val pushUps = ExerciseModel(
            3,
            "Push Ups",
            R.drawable.ic_push_up,
            false,
            false
        )

        exerciseList.add(pushUps)

        val skipping = ExerciseModel(
            4,
            "Skipping",
            R.drawable.ic_skipping,
            false,
            false
        )

        exerciseList.add(skipping)

        val cobraStretch = ExerciseModel(
            5,
            "Cobra Stretch",
            R.drawable.ic_cobra_stretch,
            false,
            false
        )

        exerciseList.add(cobraStretch)

        val stepUpDown = ExerciseModel(
            6,
            "Step Up Down",
            R.drawable.ic_step_up_down,
            false,
            false
        )

        exerciseList.add(stepUpDown)

        val sideCrunches = ExerciseModel(
            7,
            "Side Crunches Both Side",
            R.drawable.ic_side_crunches,
            false,
            false
        )

        exerciseList.add(sideCrunches)

        val sideBend = ExerciseModel(
            8,
            "Side Bend Both Sides",
            R.drawable.ic_side_bend,
            false,
            false
        )

        exerciseList.add(sideBend)

        val chest = ExerciseModel(
            9,
            "Chest Stretching",
            R.drawable.ic_chest_stretching,
            false,
            false
        )

        exerciseList.add(chest)

        val mountainClimbers = ExerciseModel(
            10,
            "Mountain Climbers",
            R.drawable.ic_mountain_climbers,
            false,
            false
        )

        exerciseList.add(mountainClimbers)

        val legRaiseCrunches = ExerciseModel(
            11,
            "Leg Raise Crunches",
            R.drawable.ic_leg_raise_crunches,
            false,
            false
        )

        exerciseList.add(legRaiseCrunches)

        val yoga = ExerciseModel(
            12,
            "Yoga Relax",
            R.drawable.ic_yoga,
            false,
            false
        )

        exerciseList.add(yoga)


        return exerciseList
    }
}