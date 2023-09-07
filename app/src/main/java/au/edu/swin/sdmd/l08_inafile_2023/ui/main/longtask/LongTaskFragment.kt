package au.edu.swin.sdmd.l08_inafile_2023.ui.main.longtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import au.edu.swin.sdmd.l08_inafile_2023.R
import au.edu.swin.sdmd.l08_inafile_2023.data.HistoryFile
import au.edu.swin.sdmd.l08_inafile_2023.data.LoooooongFile
import au.edu.swin.sdmd.l08_inafile_2023.databinding.FragmentMainBinding

class LongTaskFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_longtask, container, false)
        val bLong: Button = root.findViewById(R.id.bLong)
        bLong.setOnClickListener {
            val cgGroup: RadioGroup = root.findViewById(R.id.radioGroup)
            val listLength = when(cgGroup.checkedRadioButtonId) {
                R.id.shortList -> 1000
                R.id.mediumList -> 10000
                R.id.longList -> 100000
                else -> 1
            }
            context?.let {
                LoooooongFile.deleteFile(it)
                for (i in 1..listLength) {
                    val sBinary = Integer.toBinaryString(i)
                    LoooooongFile.appendInput(it, "$i = $sBinary")
                }
            }
        }
        return root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): LongTaskFragment {
            return LongTaskFragment()
        }
    }
}