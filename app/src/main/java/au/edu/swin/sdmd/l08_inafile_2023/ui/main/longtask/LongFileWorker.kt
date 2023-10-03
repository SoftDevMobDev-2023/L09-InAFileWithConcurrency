package au.edu.swin.sdmd.l08_inafile_2023.ui.main.longtask

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import au.edu.swin.sdmd.l08_inafile_2023.data.LoooooongFile

class LongFileWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do the work here
        LoooooongFile.deleteFile(applicationContext)
        for (i in 1..20_000) {
            val sBinary = Integer.toBinaryString(i)
            LoooooongFile.appendInput(this.applicationContext, "$i = $sBinary")
        }
        Log.i("FINISHED", "done")
        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}