package com.company.plugins;

import Instruments.Instrument;

import java.io.FileNotFoundException;

public interface IXML {
  void xmlSave(Instrument instrument);
  String readFile() throws FileNotFoundException;
}
