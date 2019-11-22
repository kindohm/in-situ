
(
SuperDirt.postBadValues = false;

// s.options.device_("JackRouter");

s.options.numBuffers = 1024 * 16;
s.options.memSize = 8192 * 16;
s.options.maxNodes = 1024 * 64;
s.options.numOutputBusChannels = 4;
s.options.numInputBusChannels = 0;

s.waitForBoot {
	~dirt = SuperDirt(2, s);
	~dirt.loadSoundFiles("/home/kindohm/live-2016/*");

	s.sync;
	~dirt.start(57120, [0, 2]);

	MIDIClient.init;
	//~midiOut = MIDIOut.newByName("Scarlett 2i4 USB", "Scarlett 2i4 USB");
	~midiOut = MIDIOut.newByName("Scarlett 2i4 USB", "Scarlett 2i4 USB MIDI 1");
	~midiOut.latency = 0;
	~dirt.soundLibrary.addMIDI(\midi, ~midiOut);

};
s.latency = 0.3;
);

