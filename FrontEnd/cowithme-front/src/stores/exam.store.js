import { defineStore } from 'pinia';
import { fetchWrapper } from 'src/helpers';

const baseUrl = 'http://i7a304.p.ssafy.io:8080/api/v1';

export const useExamStore = defineStore({
	id: 'exam',
	state: () => ({}),
	actions: {
		async makeExam(examInfo) {
			await fetchWrapper.post(`${baseUrl}/tests`, examInfo);
		},
	},
});