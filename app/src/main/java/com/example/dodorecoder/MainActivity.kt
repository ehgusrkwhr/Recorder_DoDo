package com.example.dodorecoder

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {

    companion object{
        const val REQUEST_RECORD_AUDIO_PERMISSION = 200
    }

    private val recoderButton: RecorderButton by lazy {
        findViewById(R.id.recoderButton)
    }

    private val recoderAtm: AtmView by lazy {
        findViewById(R.id.recoderAtm)
    }

    private var fileName: String = ""
    private var permissionToRecordAccepted = false
    private var permissions: Array<String> = arrayOf(Manifest.permission.RECORD_AUDIO)
    private var state = RecorderState.BEFORE_RECORDING
        set(value) {
            field = value
            recoderButton.updateStateIcon(value)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Record to the external cache directory for visibility
        ActivityCompat.requestPermissions(this, permissions, REQUEST_RECORD_AUDIO_PERMISSION)


        fileName = "${externalCacheDir?.absolutePath}/audiorecordtest.3gp"
        initView()
        bindViews()

    }


    private fun initView() {
        recoderButton.updateStateIcon(state)
    }

    private fun bindViews() {
        recoderButton.setOnClickListener {
            when (state) {
                RecorderState.BEFORE_RECORDING -> startRecording()
                RecorderState.ON_PLAYING -> stopRecording()
            }
        }
    }

    private fun startRecording() {
        state = RecorderState.ON_PLAYING
        Log.d("dodo2 ","startRecording 호출 ")

    }

    private fun stopRecording() {
        state = RecorderState.BEFORE_RECORDING
        recoderAtm
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionToRecordAccepted = if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
        if (!permissionToRecordAccepted) finish()
    }

}