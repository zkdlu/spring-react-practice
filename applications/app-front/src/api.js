const api = {
    get: async (url) => {
        const response = await fetch(`${url}`);
        return response.json();
    },
    post: async (url, body) => {
        const response = await fetch(`${url}`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",  
            },
            body: JSON.stringify(body),
        });

        return response;
    }
};

export default api;