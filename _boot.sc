
(
SuperDirt.postBadValues = false;

// s.options.device_("JackRouter");

s.options.numBuffers = 1024 * 16;
s.options.memSize = 8192 * 16;
s.options.maxNodes = 1024 * 64;
s.options.numOutputBusChannels = 8;
s.options.numInputBusChannels = 0;

s.waitForBoot {
	~dirt = SuperDirt(2, s);
	// ~dirt.loadSoundFiles("~/code/in-situ/samples/*");
	// ~dirt.loadSoundFiles("~/studio/tidal-samples-2/shared/*");

	s.sync;
	~dirt.start(57120, [0, 2,4,6]);

	MIDIClient.init;
	~midiOut = MIDIOut.newByName("Scarlett 2i4 USB", "Scarlett 2i4 USB");
	~midiOut.latency = 0;
	~dirt.soundLibrary.addMIDI(\midi, ~midiOut);


};
s.latency = 0;
);


