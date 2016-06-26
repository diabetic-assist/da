package zvr.da

import android.app.Activity
import android.os.Bundle
import android.view.View.OnClickListener
import android.view.{View, ViewGroup}

class DiabeticAssist extends Activity {

  val addMeasurementOnClick: OnClickListener = new OnClickListener {

    def addMeasurementFragment(parent_view: ViewGroup): Unit = {
      val fragman = getFragmentManager
      val fragTransaction = fragman.beginTransaction()

      fragTransaction.add(R.id.addMeasurementPanel, AddMeasurmentFragment())

      fragTransaction.commit()
    }

    override def onClick(add_button: View): Unit = {
      addMeasurementFragment(add_button.getParent.asInstanceOf[ViewGroup])
    }
  }

  override def onCreate(state : Bundle) = {
    super.onCreate(state)
    setContentView(R.layout.add_measurement)
    findViewById(R.id.add_button).setOnClickListener(addMeasurementOnClick)
  }


}