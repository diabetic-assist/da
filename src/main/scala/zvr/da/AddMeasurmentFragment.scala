package zvr.da

import android.app.Fragment
import android.os.Bundle
import android.view.{LayoutInflater, View, ViewGroup}

class AddMeasurmentFragment extends Fragment {
  override def onCreateView(inflator: LayoutInflater, container: ViewGroup, state: Bundle) : View = {
     inflator.inflate(R.layout.edit_measurement, container, false)
  }

}

object AddMeasurmentFragment {
  def apply() = {
    new AddMeasurmentFragment()
  }
}
